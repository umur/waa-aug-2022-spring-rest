var serverUrl = 'http://localhost:8080'
window.onload = function () {
    document.getElementById('studentForm').onsubmit = function (e) {
        e.preventDefault();
        saveNewStudent();
    }

    getAllStudents();
}

function saveNewStudent() {
    let form = document.getElementById('studentForm');
    var formData = new FormData(form);
    let bodyJson = JSON.stringify(Object.fromEntries(formData));
    console.log(bodyJson);
    fetch(serverUrl + "/Students", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'accept':'*/*'
        },
        body: bodyJson
    })
        .then(response => {
            if(response.ok){
                getAllStudents();
            }
        })
}

function getAllStudents() {
    fetch(serverUrl + "/Students")
        .then(response => response.json())
        .then(data => {
            let html = ``;
            data.forEach(element => {
                html += `  <tr>
        <th scope="row">${element.id}</th>
        <td>${element.firstname}</td>
        <td>${element.lastname}</td>
        <td>${element.email}</td>
        <td>${element.major}</td>
        <td>${element.gpa}</td>
        <td>
            <button type="button" class="btn btn-danger" onclick="deleteStudent(${element.id})"><i class="bi bi-trash"></i></button>
        </td>
    </tr>`
            });
            document.getElementById('tbody').innerHTML = html;
        })
}

function deleteStudent(id) {
    console.log('Delete Student id:' + id);
    fetch(serverUrl + "/Students/"+id, {
        method: 'DELETE'
    })
        .then(response => {
            if(response.ok){
                getAllStudents();
            }
        })
}

