
const clientURL = location.origin + location.pathname.split('/').slice(0, location.pathname.split('/').length - 1).join('/');
const serverUrl = 'http://localhost:8080';

let id;

window.onload = function() {
    id = new URL(location.href).searchParams.get('id');
    if(id) {
        fetchStudentById(id);
        document.getElementById('id').readOnly = true;
    }
    document.getElementById('submitBtn').onclick = submit;
};

async function fetchStudentById(id) {
    const response = await fetch(serverUrl + '/api/v1/students/' +  id);
    if(response.ok){
        let json = await response.json();  
        if(json.error) {
            postErrorMsg(json.error);
        } else {
            const student = json;
            document.getElementById('id').value = student.id;
            document.getElementById('firstname').value = student.firstname;
            document.getElementById('lastname').value = student.lastname;
            document.getElementById('email').value = student.email;
            document.getElementById('major').value = student.major;
            document.getElementById('gpa').value = student.gpa;
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

function submit() {
    if(id) {
        editStudent();
    } else {
        addStudent();
    }
}

async function addStudent() {
    const student = {};
    student.id = document.getElementById('id').value;
    student.firstname = document.getElementById('firstname').value;
    student.lastname = document.getElementById('lastname').value;
    student.email = document.getElementById('email').value;
    student.major = document.getElementById('major').value;
    student.gpa = document.getElementById('gpa').value;

    student.coursesTaken = [];

    let response = await fetch(serverUrl + '/api/v1/students/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(student)
    });

    if(response.ok) {
        location.assign(clientURL + '/index.html')
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function editStudent() {
    const student = {};
    student.id = document.getElementById('id').value;
    student.firstname = document.getElementById('firstname').value;
    student.lastname = document.getElementById('lastname').value;
    student.email = document.getElementById('email').value;
    student.major = document.getElementById('major').value;
    student.gpa = document.getElementById('gpa').value;

    student.coursesTaken = [];

    let response = await fetch(serverUrl + '/api/v1/students/' + student.id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(student)
    });

    if(response.ok) {
        location.assign(clientURL + '/index.html')
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

function postErrorMsg(msg) {
    document.getElementById('errorMsg').innerHTML = msg;
}