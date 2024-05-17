import React, { useState, useEffect } from 'react';

export function EditMeal() {
  const [title, setTitle] = useState('');
  const [introtext, setIntrotext] = useState('');
  const [description, setDescription] = useState('');
  const [errorMessage, setErrorMessage] = useState(null);

  const fieldErrors = {
    title: 'Title is required!',
    introtext: 'Intro Text is required!',
    description: 'Description is required!',
  };

  const handleClick = async () => {
    // Individual field validation
    let hasError = false;
    const errorMessages = []; // Define errorMessages inside the function

    if (!title) {
      hasError = true;
      errorMessages.push(fieldErrors.title);
    }

    if (!introtext) {
      hasError = true;
      errorMessages.push(fieldErrors.introtext);
    }

    if (!description) {
      hasError = true;
      errorMessages.push(fieldErrors.description);
    }

    if (hasError) {
      setErrorMessage(errorMessages.join('\n')); // Combine error messages
      return;
    }

    try {
      const response = await fetch('/api/meal', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, introtext, description }),
      });

      if (!response.ok) {
        throw new Error(`Error submitting data: ${response.statusText}`);
      }

      // Handle successful submission (clear form, etc.)
      setTitle('');
      setIntrotext('');
      setDescription('');
      setErrorMessage(null);
      console.log('Data submitted successfully!');
    } catch (error) {
      setErrorMessage(error.message);
    }
  };

  return (
    <form className="mb-3">
      <h2>Edit Meal</h2>
      <div className="form-group">
        <label htmlFor="title" className="form-label">
          Title:
        </label>
        <input
          type="text"
          id="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
          className="form-control"
        />
        {errorMessage && errorMessages.includes(fieldErrors.title) && (
          <p className="text-danger">{errorMessage}</p>
        )}
      </div>
      <div className="form-group">
        <label htmlFor="introtext" className="form-label">
          Intro Text:
        </label>
        <textarea
          id="introtext"
          value={introtext}
          onChange={(e) => setIntrotext(e.target.value)}
          required
          className="form-control"
        />
        {errorMessage && errorMessages.includes(fieldErrors.introtext) && (
          <p className="text-danger">{errorMessage}</p>
        )}
      </div>
      <div className="form-group">
        <label htmlFor="description" className="form-label">
          Description:
        </label>
        <textarea
          id="description"
          value={description}
          onChange={(e) => setDescription(e.value)} // Minor typo fix (setValue -> setDescription)
          required
          className="form-control"
        />
        {errorMessage && errorMessages.includes(fieldErrors.description) && (
          <p className="text-danger">{errorMessage}</p>
        )}
      </div>
      <button type="button" onClick={handleClick} className="btn btn-primary">
        Save Changes
      </button>
    </form>
  );
}
