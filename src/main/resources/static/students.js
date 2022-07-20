const host = 'http://localhost:8080';
window.onload = function () {
    if (getStudentId()) {
        fetch(`${host}/api/students/courses/${getStudentId()}`)
            .then(response => response.json())
            .then(courses => {
                courses.forEach(item => {
                    const parent = getElement("courses");
                    let row = createRow();
                    row.append(createCol(item.id));
                    row.append(createCol(item.name));
                    row.append(createCol(item.code));
                    let actions = document.createElement('td');
                    let deleteButton = document.createElement('button');
                    deleteButton.innerText = 'Remove';
                    deleteButton.onclick = onRemoveCourse.bind(item);
                    actions.append(deleteButton);
                    row.append(actions);
                    parent.appendChild(row);
                })

                fetch(`${host}/api/courses`)
                    .then(response => response.json())
                    .then(response => {
                        const element = document.getElementById('allCourses');
                        if (element) {
                            response.filter(item => !courses.map(c => c.code).includes(item.code)).forEach(item => {
                                const option = document.createElement('option');
                                option.value = item.code;
                                option.label = `${item.name} ${item.code}`;
                                element.append(option);
                            })
                        }
                    });
            });


    }
}

function getStudentId() {
    const urlSearchParams = new URLSearchParams(window.location.search);
    const params = Object.fromEntries(urlSearchParams.entries());
    return params.id;
}

function onAddCourse() {
    document.getElementById('selector').style.display = 'block';
}

function onRemoveCourse() {
    const yes = confirm('Are you sure?');
    if (yes) {
        fetch(`${host}/api/students/courses/${getStudentId()}/${this.code}`, {
            method: 'DELETE',
        })
            .then(response => response.json())
            .then(response => {
                location.reload();
            });
    }
}

function onCancel() {
    document.getElementById('selector').style.display = 'none';
}

function onAddToStudent() {
    const element = document.getElementById('allCourses');
    if (element.value !== 'null') {
        fetch(`${host}/api/students/courses/${getStudentId()}/${element.value}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(response => {
                location.reload();
            });
    }
}

function getElement(id) {
    return document.getElementById(id);
}

function createRow() {
    return document.createElement("tr");
}

function createCol(value) {
    let element = document.createElement("td");
    element.innerHTML = value;
    return element;
}