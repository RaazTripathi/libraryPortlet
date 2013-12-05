create table library_LMSBook (
	bookId LONG not null primary key,
	bookTitle VARCHAR(75) null,
	author VARCHAR(75) null,
	dateAdded DATE null
);