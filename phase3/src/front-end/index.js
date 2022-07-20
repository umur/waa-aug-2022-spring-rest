let localHost = "http://localhost:8080/"
let courseURL = `${localHost}/courses`
let studentURL = `${localHost}/students`

window.onload = function () {
    //change view to student
    document.getElementById("courseBtn").addEventListener('click', (event) => {
        document.getElementById("course").style.display = "none";
        document.getElementById("student").style.display = "Block";
    })

    //change view to course
    document.getElementById("studentBtn").addEventListener('click', (event) => {
        document.getElementById("course").style.display = "Block";
        document.getElementById("student").style.display = "none";
    })

    //search course by Id. Using Api get courses/{courseId}
    document.getElementById("searchCourseByIdBtn").addEventListener('click', async (event) => {
        let courseId = document.getElementById("searchCourseId").value;
        let data = await fetch(`${courseURL}/${courseId}`, {
            method: "GET"
        });
        updateCourseTableBody("courseBody", data);
    })

    //get all courses. Using Api get courses/
    document.getElementById("getCourseBtn").addEventListener('click', async (event) => {
        let data = await fetch(`${courseURL}`, {
            method: "GET"
        });
        updateCourseTableBody("courseBody", data);
    })

    //add course. Using Api post courses/
    document.getElementById("addCourseBtn").addEventListener('click', async (event) => {
        await fetch(`${courseURL}`, {
            method: "POST",
            body: JSON.stringify(getCourseInput())
        });
    })

    //update course. Using Api put courses/
    document.getElementById("updateCourseBtn").addEventListener('click', async (event) => {
        let courseId = document.getElementById("courseId").value;
        await fetch(`${courseURL}/${courseId}`, {
            method: "PUT",
            body: JSON.stringify(getCourseInput())
        });
    })

    //delete course by id. Using Api post courses/{courseId}
    document.getElementById("deleteCourseByIdBtn").addEventListener('click', async (event) => {
        let courseId = document.getElementById("searchCourseId").value;
        await fetch(`${courseURL}/${courseId}`, {
            method: "DELETE",
        });
    })

    //add student. Using Api post students/
    document.getElementById("addStudentBtn").addEventListener('click', async (event) => {
        await fetch(`${studentURL}`, {
            method: "POST",
            body: JSON.stringify(getStudentInput())
        });
    })

    //update student. Using Api put students/
    document.getElementById("updateStudentBtn").addEventListener('click', async (event) => {
        let studentId = document.getElementById("studentId").value;
        await fetch(`${studentURL}/${studentId}`, {
            method: "PUT",
            body: JSON.stringify(getStudentInput())
        });
    })

    //search student by Id. Using Api get students/{studentId}
    document.getElementById("searchStudentByIdBtn").addEventListener('click', async (event) => {
        let studentId = document.getElementById("searchStudentId").value;
        let data = await fetch(`${studentURL}/${studentId}`, {
            method: "GET"
        });
        updateStudentTableBody(data);
    })

    //search course student's Id. Using Api get students/{studentId}/courses
    document.getElementById("searchStuCourseByIdBtn").addEventListener('click', async (event) => {
        let studentId = document.getElementById("searchStudentId").value;
        let data = await fetch(`${studentURL}/${studentId}/courses`, {
            method: "GET"
        });
        updateCourseTableBody("searchCourseBody", data);
    })

    //search course student's Id. Using Api get students/{studentId}/courses
    document.getElementById("deleteStudentByIdBtn").addEventListener('click', async (event) => {
        let studentId = document.getElementById("searchStudentId").value;
        let data = await fetch(`${studentURL}/${studentId}`, {
            method: "DELETE"
        });
        updateStudentTableBody(data);
    })

    //search student by major. Using Api get students/major/{major}
    document.getElementById("searchStudentByMajorBtn").addEventListener('click', async (event) => {
        let major = document.getElementById("searchStudentMajor").value;
        let data = await fetch(`${studentURL}/major/${major}`, {
            method: "GET"
        });
        updateStudentTableBody(data);
    })

    //get students. Using Api get students
    document.getElementById("getStudentBtn").addEventListener('click', async (event) => {
        let data = await fetch(`${studentURL}`, {
            method: "GET"
        });
        updateStudentTableBody(data);
    })
}

function getCourseInput() {
    return {
        "id": document.getElementById("courseId").value,
        "name": document.getElementById("courseName").value,
        "code": document.getElementById("courseCode").value,
    }
}

function getStudentInput() {
    return {
        "id": document.getElementById("studentId").value,
        "firstName": document.getElementById("studentFn").value,
        "lastName": document.getElementById("studentLn").value,
        "email": document.getElementById("studentEmail").value,
        "major": document.getElementById("studentMajor").value,
        "gpa": document.getElementById("studentGpa").value,
        "coursesTaken": [{
            "id": document.getElementById("stuCourseId").value,
            "name": document.getElementById("stuCourseName").value,
            "code": document.getElementById("stCourseCode").value,
        }]
    }
}

function updateCourseTableBody(id, data) {
    //init value
    document.getElementById(id).innerHTML = ``;
    data.forEach(row => addRowToTableCourse(id, row));
}

function addRowToTableCourse(id, row) {
    document.getElementById(id).innerHTML += `<tr>
    <td>${row.id}</td>
    <td>${row.name}</td>
    <td>${row.code}</td>
</tr>`;
}

function updateStudentTableBody(data) {
    //init value
    document.getElementById("studentBody").innerHTML = ``;
    data.forEach(row => addRowToTableStudent(row));
}

function addRowToTableStudent(row) {
    let courseTaken = addTableToCellCourseTaken(row.coursesTaken);
    document.getElementById("studentBody").innerHTML += `<tr>
    <td>${row.id}</td>
    <td>${row.firstName}</td>
    <td>${row.lastName}</td>    
    <td>${row.email}</td>
    <td>${row.major}</td>
    <td>${row.gpa}</td>
    <td>${courseTaken}</td>
</tr>`;
}

function addTableToCellCourseTaken(data) {
    let result = `<table>`
    data.forEach(row => {
        result += `<tr>
            <td>${row.id}</td>
            <td>${row.name}</td>
            <td>${row.code}</td>
        </tr>`;
    })
    result += `</table>`;
    return result;
}

