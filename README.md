# 📚 Library Management System – Java

A **Java console application** to manage library books efficiently.  
It supports adding, viewing, issuing, and returning books, with **persistent storage** so data is not lost when the program closes.

---

## 🚀 Features
- **Add Books** – Enter book title and author.
- **View All Books** – See a list of books with availability status.
- **Issue a Book** – Mark a book as issued so it cannot be reissued until returned.
- **Return a Book** – Mark a book as available again.
- **Persistent Storage** – Saves data automatically to a file (`library.ser`).

---

## 🛠️ Technologies Used
- **Java** (Core)
- **Object-Oriented Programming** (OOP)
- **File Handling** using `ObjectOutputStream` & `ObjectInputStream`
- **Collections Framework** (`ArrayList`)

---

## 📂 Project Structure
```
LibraryManagementSystem.java     # Main source code
library.ser                      # Auto-generated data file for book records
README.md                        # Documentation with project details
```

---

## 📥 How to Run
1. **Compile the Java Program**
```bash
javac LibraryManagementSystem.java
```

2. **Run the Program**
```bash
java LibraryManagementSystem
```

3. **Follow the Menu**
```
===== Library Management System =====
1. Add Book
2. View Books
3. Issue Book
4. Return Book
5. Save & Exit
Enter your choice:
```

---

## 🖥️ Sample Output
```
===== Library Management System =====
1. Add Book
2. View Books
3. Issue Book
4. Return Book
5. Save & Exit
Enter your choice: 1
Enter book title: Java Programming
Enter author: James Gosling
Book added successfully!

===== Library Management System =====
1. Add Book
2. View Books
3. Issue Book
4. Return Book
5. Save & Exit
Enter your choice: 2
--- Library Books ---
1. Java Programming by James Gosling (Available)
```

---

## 📌 Future Enhancements
- Add **search functionality** for books by title or author.
- Implement **user authentication** for librarians.
- Provide **due dates** and **fine calculation** for late returns.
- Create a **GUI version** using Java Swing or JavaFX.

---

## 📄 License
This project is licensed under the **MIT License** – feel free to use, modify, and distribute.

---

### 👨‍💻 Author
**Sowmya B** – Developer & Maintainer  
📧 Email: sowmyachowdary2004@gmail.com  
🔗 GitHub: [https://github.com/sowmya-chowdary/](https://github.com/sowmya-chowdary/)
