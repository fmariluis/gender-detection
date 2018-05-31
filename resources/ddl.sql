CREATE TABLE names(
  "name" TEXT,
  "gender" TEXT,
  "language" TEXT
);

CREATE INDEX language_idx ON names(language);
