const url = "http://localhost:8080/"

async function showAllCourses() {
    let response = await fetch(url + "courses");
    let courses = await response.json();
    let tableElement = document.getElementById('courseTable');
    let tableBody = '';
    for (let course of courses) {
        tableBody += '<tr>'

        tableBody += '<th scope="row">'
        tableBody += course.id;
        tableBody += '</th>'

        tableBody += '<td>'
        tableBody += course.name;
        tableBody += '</td>'

        tableBody += '<td>'
        tableBody += course.code;
        tableBody += '</td>'

        tableBody += '</tr>'
    }
    tableElement.innerHTML = tableBody;
}