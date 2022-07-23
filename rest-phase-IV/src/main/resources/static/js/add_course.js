const clientURL = location.origin + location.pathname.split('/').slice(0, location.pathname.split('/').length - 1).join('/');
const serverUrl = 'http://localhost:8080';

let id;

window.onload = function() {
    id = new URL(location.href).searchParams.get('id');
    if(id) {
        fetchCourseById(id);
        document.getElementById('id').readOnly = true;
    }
    document.getElementById('submitBtn').onclick = submit;
};

async function fetchCourseById(id) {
    const response = await fetch(serverUrl + '/api/v1/courses/' +  id);
    if(response.ok){
        let json = await response.json();  
        if(json.error) {
            postErrorMsg(json.error);
        } else {
            const course = json;
            document.getElementById('id').value = course.id;
            document.getElementById('name').value = course.name;
            document.getElementById('code').value = course.code;
        }
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

function submit() {
    if(id) {
        editCourse();
    } else {
        addNewCourse();
    }
}

async function addNewCourse() {
    const course = {};
    course.id = document.getElementById('id').value;
    course.name = document.getElementById('name').value;
    course.code = document.getElementById('code').value;

    let response = await fetch(serverUrl + '/api/v1/courses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(course)
    });

    if(response.ok) {
        history.back();
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

async function editCourse() {
    const course = {};
    course.id = document.getElementById('id').value;
    course.name = document.getElementById('name').value;
    course.code = document.getElementById('code').value;

    let response = await fetch(serverUrl + '/api/v1/courses/' + course.id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(course)
    });

    if(response.ok) {
        history.back();
    } else {
        postErrorMsg('HTTP error ' + response.status);
    }
}

function postErrorMsg(msg) {
    document.getElementById('errorMsg').innerHTML = msg;
}