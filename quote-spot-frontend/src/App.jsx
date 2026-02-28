import { useEffect, useState } from "react";
import "./App.css";

function App() {

  const [quotes, setQuotes] = useState([]);
  const [newQuote, setNewQuote] = useState("");

  const API_URL = "http://prodhost:9090/quotes";

  // Fetch quotes
  const loadQuotes = async () => {
    const res = await fetch(API_URL);
    const data = await res.json();
    setQuotes(data);
  };

  // Add quote
  const addQuote = async () => {

    if (!newQuote.trim()) return;

    await fetch(API_URL, {
      method: "POST",
      headers: {
        "Content-Type": "text/plain"
      },
      body: newQuote
    });

    setNewQuote("");
    loadQuotes();
  };

  useEffect(() => {
    loadQuotes();
  }, []);

  return (
    <div className="container">

      <h1>Quote Spot</h1>

      <div className="input-box">

        <input
          type="text"
          placeholder="Enter new quote..."
          value={newQuote}
          onChange={(e) => setNewQuote(e.target.value)}
        />

        <button onClick={addQuote}>
          Add
        </button>

      </div>

      <ul className="quote-list">
        {quotes.map((q, i) => (
          <li key={i}>{q}</li>
        ))}
      </ul>

    </div>
  );
}

export default App;
