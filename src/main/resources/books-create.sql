CREATE TABLE IF NOT EXISTS books (
       id SERIAL PRIMARY KEY,
       name TEXT NOT NULL,
       author TEXT NOT NULL,
       publishing_year INT NOT NULL,
       isbn TEXT NOT NULL UNIQUE,
       publisher TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS visitors (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    phone TEXT NOT NULL,
    subscribed BOOL NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS visitor_books (
    visitor_id INT REFERENCES visitors(id) ON DELETE CASCADE,
    book_id INT REFERENCES books(id) ON DELETE CASCADE
);