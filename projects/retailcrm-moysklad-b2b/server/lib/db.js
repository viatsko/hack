import sqlite3 from 'sqlite3';

const db = new sqlite3.verbose().Database(`${__dirname}/../db/db.sqlite`);

export default db;
