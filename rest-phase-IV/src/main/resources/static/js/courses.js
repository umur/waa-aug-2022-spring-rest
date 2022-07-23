const clientURL = location.origin + location.pathname.split('/').slice(0, location.pathname.split('/').length - 1).join('/');
const serverUrl = 'http://localhost:8080';

let courses;
let student;

window.onload = function(){
    courses = [];
    fetchCourses();
    const id = new URL(location.href).searchParams.get('id');
    if(id) 
        fetchStudentById(id);
    document.getElementById('addCourseBtn').onclick = addCourse;
    document.getElementById('doneBtn').onclick = done;
}

async function fetchCourses() {
    const response = await fetch(serverUrl + '/api/v1/courses');
    if(response.ok){
        let json = await response.json();  
        if(json.error) {
            postErrorMsg(json.error);
        } else {
            courses = json;
            populateCourses('course-list');
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function fetchStudentById(id) {
    const response = await fetch(serverUrl + '/api/v1/students/' +  id);
    if(response.ok){
        let json = await response.json();  
        if(json.error) {
            postErrorMsg(json.error);
        } else {
            student = json;
            document.getElementById('studentCourseTitle').innerHTML = 'Courses for student ' + student.firstname + ' ' + student.lastname;
            populateCourses('student-course-list');
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function deleteCourse() {
    const response = await fetch(serverUrl + '/api/v1/courses/' + this.id, {
        method: 'DELETE'
    });

    if(response.ok) {
        const course = await response.json();  
        if(course) {
            const index = courses.findIndex(c => c.id === course.id);
            if(index > -1) {
                courses = courses.filter(c => c.id !== course.id);
                populateCourses('course-list');
            } else {
                postErrorMsg('course not found');
            }
        } else {
            postErrorMsg('course returned null when calling delete');
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function deleteCourseFromStudent() {
    const response = await fetch(serverUrl + '/api/v1/students/' + student.id + '/courses/' + this.id, {
        method: 'DELETE'
    });

    if(response.ok) {
        const studentCourses = await response.json();  
        if(studentCourses) {
            student.coursesTaken = studentCourses;
            populateCourses('student-course-list');
        } else {
            postErrorMsg('student or course id not match returned null when calling delete');
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function addCourseToStudent() {
    const response = await fetch(serverUrl + '/api/v1/students/' + student.id + '/courses/' + this.id, {
        method: 'POST'
    });

    if(response.ok) {
        const studentCourses = await response.json();  
        if(studentCourses) {
            student.coursesTaken = studentCourses;
            populateCourses('student-course-list');
        } else {
            postErrorMsg('student or course id not match returned null when calling add');
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

function addCourse() {
    location.assign(clientURL + '/add_course.html');
}

async function done() {
    history.back();
}

function postErrorMsg(msg) {
    document.getElementById('errorMsg').innerHTML = msg;
}

function populateCourses(tag) {
    document.getElementById(tag).innerHTML = '';
    const coursesToRender = tag === 'course-list' ? courses : student.coursesTaken;
    if(coursesToRender.length > 0) {
        coursesToRender.forEach(c=>renderCourse(c, tag));
    }
}

function renderCourse(course, tag) {
    const tr = document.createElement('tr');
    tr.id = 'tr-course-' + course.id;

    const id = document.createElement('td');
    id.innerHTML = course.id;

    const name = document.createElement('td');
    name.innerHTML = course.name;

    const code = document.createElement('td');
    code.innerHTML = course.code;

    const actionTd = document.createElement('td');

    if(tag === 'course-list') {

        const addActionA  = document.createElement('a');
        const addAction = document.createElement('img');
        addAction.src = './views/add.svg';
        addAction.alt = 'add course to student';
        addAction.className = 'action-img';
        addAction.onclick = () => addCourseToStudent.call(course);
        addActionA.appendChild(addAction);
        
        actionTd.appendChild(addActionA);

        const editActionA  = document.createElement('a');
        const editAction = document.createElement('img');
        editAction.src = './views/edit.svg';
        editAction.alt = 'edit course';
        editAction.className = 'action-img';
        editAction.onclick = () => editCourse.call(course);
        editActionA.appendChild(editAction); 
        actionTd.appendChild(editActionA)

    }

    const deleteActionA  = document.createElement('a');
    const deleteAction = document.createElement('img');
    deleteAction.src = './views/delete.svg';
    deleteAction.alt = 'delete course';
    deleteAction.className = 'action-img';
    deleteAction.onclick = () => tag === 'course-list' ? deleteCourse.call(course) : deleteCourseFromStudent.call(course);
    deleteActionA.appendChild(deleteAction);

    actionTd.appendChild(deleteActionA);

    tr.appendChild(id);
    tr.appendChild(name);
    tr.appendChild(code);
    tr.appendChild(actionTd);

    document.getElementById(tag).appendChild(tr);
} 

function editCourse() {
    location.assign(clientURL + '/add_course.html?id=' + this.id);
}