# About

Task tracker is a project used to track and manage your tasks. 

Using command line interface (CLI), you can track what you need to do, what you have done, and what you are currently working on.

Project idea from [roadmap.sh](https://roadmap.sh/projects/task-tracker)

# Requirements / Objectives

The application should run from the command line, accept user actions and inputs as arguments, and store the tasks in a JSON file. 

The user should be able to:

    Add, Update, and Delete tasks
    Mark a task as in progress or done
    List all tasks
    List all tasks that are done
    List all tasks that are not done
    List all tasks that are in progress

# Constraints

Some constraints to guide the implementation:

    Use positional arguments in command line to accept user inputs.
    Use a JSON file to store the tasks in the current directory.
    The JSON file should be created if it does not exist.
    Use the native file system module of your programming language to interact with the JSON file.
    Do not use any external libraries or frameworks to build this project.
    Ensure to handle errors and edge cases gracefully.
