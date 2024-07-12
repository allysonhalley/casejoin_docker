CREATE TABLE products (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT,
    category_id TEXT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);