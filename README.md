# Check-in Employee App

This project is an employee check-in application designed to manage and track employee presence. It is a full-stack application built using **JavaScript**, **CSS**, and **Java**.

## Features

* **Employee Check-in/Check-out:** A system for employees to record their arrival and departure times.
* **Database Integration:** The application uses a database to store and retrieve employee check-in data, indicated by the provided schema files.
* **Full-Stack Architecture:** The project is structured with separate frontend and backend components.

## Technologies Used

* **JavaScript:** The main language for the application logic.
* **CSS:** Used for styling the user interface.
* **Java:** Used for some parts of the backend or specific functionalities.

## Project Structure

* `app/`: Contains all the frontend code, including HTML, CSS, and JavaScript files for the user interface.
* `server/`: Contains the backend code and server-side logic.
* `script/`: Houses various utility or build scripts for the project.
* `.vscode/`: Configuration files for the VS Code editor.

## Getting Started

To set up and run the project locally, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/linamandresy/check-in-employe-app.git](https://github.com/linamandresy/check-in-employe-app.git)
    ```

2.  **Navigate to the project directory:**
    ```bash
    cd check-in-employe-app
    ```

3.  **Install dependencies:**
    The project likely uses a package manager like npm. You'll need to install dependencies for both the frontend and backend.

    ```bash
    # Install server dependencies
    cd server
    npm install
    
    # Install frontend dependencies
    cd ../app
    npm install
    ```

4.  **Database Setup:**
    * Set up your database based on the schema files (`mcd.lo1`, `mcd.loo`).
    * Update the database connection details in your configuration files.

5.  **Run the application:**
    Start both the server and the frontend.

    ```bash
    # From the server directory, start the backend
    npm start
    
    # From the app directory, start the frontend
    npm start
    ```

---

## To-Do List

For a list of outstanding tasks and planned features, please refer to the `to-do.xlsx` file.
