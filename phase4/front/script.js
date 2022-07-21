const baseUrl = "http://localhost:8080/"

async function showCourses() {
    let resp = await fetch(baseUrl + "courses");
    let data = await resp.json();
    let tableElement = document.getElementById('courses');
    let tableBody = '';
    for (let el of data) {
        tableBody += '<tr>'

        tableBody += '<th scope="row">'
        tableBody += el.id;
        tableBody += '</th>'

        tableBody += '<td>'
        tableBody += el.name;
        tableBody += '</td>'

        tableBody += '<td>'
        tableBody += el.code;
        tableBody += '</td>'

        tableBody += '</tr>'
    }
    tableElement.innerHTML = tableBody;
}

async function showStudents() {
    let response = await fetch(baseUrl + "students");
    let data = await response.json();
    let tableElement = document.getElementById('students');
    let tableBody = '';
    for (let el of data) {
        tableBody += '<tr>'

        tableBody += '<th scope="row">'
        tableBody += el.id;
        tableBody += '</th>'

        tableBody += '<td>'
        tableBody += el.firstName;
        tableBody += '</td>'

        tableBody += '<td>'
        tableBody += el.lastName;
        tableBody += '</td>'

        tableBody += '<td>'
        tableBody += el.email;
        tableBody += '</td>'

        tableBody += '<td>'
        tableBody += el.major;
        tableBody += '</td>'

        tableBody += '<td>'
        tableBody += el.gpa;
        tableBody += '</td>'

        tableBody += '</tr>'
    }
    tableElement.innerHTML = tableBody;
}