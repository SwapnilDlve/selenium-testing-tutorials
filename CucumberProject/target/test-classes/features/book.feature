Feature: Datatable Feature

  Scenario: Book Scenario
    Given the following are the books in the store
      | bookid  | bookname | bookcost |
      | bkid123 | java     |   500.00 |
      | bkid567 | html5    |   550.00 |
    When the user search for book by name
    Then user will get the book info
      | banglore  |
      | hyderabad |
      | chennai   |
