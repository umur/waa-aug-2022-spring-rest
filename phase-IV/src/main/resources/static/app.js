const baseUrl = "http://localhost:8080"

const getAllCourses = async () => {
    const fields = ['id', 'name', 'code'];
    const url = `${baseUrl}/courses`;
    await fetchDataAndShowList(url, fields);
}

const getAllStudents = async () => {
    const fields = ['id', 'firstName', 'lastName', 'email', 'major', 'gpa'];
    const url = `${baseUrl}/students`;
    await fetchDataAndShowList(url, fields);
}

const fetchDataAndShowList = async (url, fields) => {
    const response = await fetch(url);
    const rows = await response.json();
    const table = document.getElementById('table-items');
    let content = '<tr>';
    for (const field of fields) {
        content += '<th scope="row">';
        content += field.toUpperCase();
        content += '</th>';
    }
    content += '</tr>';
    for (const row of rows) {
        content += '<tr>'
        for (const field of fields) {
            content += '<th scope="row">'
            content += row[field];
            content += '</th>'
        }
        content += '</tr>'
    }
    table.innerHTML = content;
}