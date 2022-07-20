const baseUrl = "http://localhost:8080/"

async function showCourses() {
    let resp = await fetch(baseUrl + "courses");
    let data = await resp.json();
    let tableElement = document.getElementById('courses-list');
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