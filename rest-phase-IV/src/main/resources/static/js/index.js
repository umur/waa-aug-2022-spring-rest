const clientURL = location.origin + location.pathname.split('/').slice(0, location.pathname.split('/').length - 1).join('/');
const serverUrl = 'http://localhost:8080';

let students;

window.onload = function(){
    students = [];
    fetchStudents();
    document.getElementById('addStudentBtn').onclick = addStudent;
}

async function fetchStudents() {
    let response = await fetch(serverUrl + '/api/v1/students');
    if(response.ok){
        let json = await response.json();  
        if(json.error) {
            postErrorMsg(json.error);
        } else {
            students = json;
            populateStudents();
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}


async function deleteStudent() {
    let response = await fetch(serverUrl + '/api/v1/students/' + this.id, {
        method: 'DELETE'
    });

    if(response.ok) {
        const student = await response.json();  
        if(student) {
            const index = students.findIndex(s => s.id === student.id);
            if(index > -1) {
                students = students.filter(s => s.id !== student.id);
                populateStudents();
            } else {
                postErrorMsg('student not found');
            }
        } else {
            postErrorMsg('student returned null when calling delete');
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function addStudent() {
    location.assign(clientURL + '/add_student.html');
}

function postErrorMsg(msg) {
    document.getElementById('errorMsg').innerHTML = msg;
}

function populateStudents() {
    document.getElementById('student-list').innerHTML = '';
    if(students.length > 0) {
        students.forEach(s=>renderStudent(s));
    }
}

function renderStudent(student) {
    const tr = document.createElement('tr');
    tr.id = 'tr-stud-' + student.id;

    const id = document.createElement('td');
    id.innerHTML = student.id;

    const fname = document.createElement('td');
    fname.innerHTML = student.firstname;

    const lname = document.createElement('td');
    lname.innerHTML = student.lastname;

    const email = document.createElement('td');
    email.innerHTML = student.email;

    const major = document.createElement('td');
    major.innerHTML = student.major;

    const gpa = document.createElement('td');
    gpa.innerHTML = student.gpa;

    const coursesTaken = document.createElement('td');
    coursesTaken.innerHTML = student.coursesTaken.length;

    const actionTd = document.createElement('td');

    const editActionA  = document.createElement('a');
    const editAction = document.createElement('img');
    editAction.src = './views/edit.svg';
    editAction.alt = 'edit student';
    editAction.className = 'action-img';
    editAction.onclick = () => editStudent.call(student);
    editActionA.appendChild(editAction); 

    const deleteActionA  = document.createElement('a');
    const deleteAction = document.createElement('img');
    deleteAction.src = './views/delete.svg';
    deleteAction.alt = 'delete student';
    deleteAction.className = 'action-img';
    deleteAction.onclick = () => deleteStudent.call(student);
    deleteActionA.appendChild(deleteAction);

    const coursesActionA  = document.createElement('a');
    const coursesAction = document.createElement('img');
    coursesAction.src = './views/list.svg';
    coursesAction.alt = 'view student detail';
    coursesAction.className = 'action-img';
    coursesAction.onclick = () => viewStudentCourses.call(student);
    coursesActionA.appendChild(coursesAction);

    actionTd.appendChild(editActionA);
    actionTd.appendChild(deleteActionA);
    actionTd.appendChild(coursesActionA);

    tr.appendChild(id);
    tr.appendChild(fname);
    tr.appendChild(lname);
    tr.appendChild(email);
    tr.appendChild(major);
    tr.appendChild(gpa);
    tr.appendChild(coursesTaken);
    tr.appendChild(actionTd);

    document.getElementById('student-list').appendChild(tr);
} 

function editStudent() {
    location.assign(clientURL + '/add_student.html?id=' + this.id);
}

function viewStudentCourses() {
    location.assign(clientURL + '/courses.html?id=' + this.id);
}