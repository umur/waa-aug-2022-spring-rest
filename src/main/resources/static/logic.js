const host = 'http://localhost:8080';
window.onload = function () {
    console.log('onload');
    fetch(`${host}/api/students`)
        .then(response => response.json())
        .then(response => {
            const parent = getElement("students");
            response.forEach(item => {
                let row = createRow();
                row.append(createCol(item.id));
                row.append(createCol(item.firstName));
                row.append(createCol(item.lastName));
                row.append(createCol(item.email));
                row.append(createCol(item.major));
                row.append(createCol(item.gpa));
                row.append(createCol(item.coursesTaken.length));
                const actions = document.createElement('td');
                const showButton = document.createElement('button');
                showButton.innerText = 'Show courses';
                showButton.onclick = onShow.bind(item);
                const editButton = document.createElement('button');
                editButton.innerText = 'Edit';
                editButton.onclick = onEdit.bind(item);
                const deleteButton = document.createElement('button');
                deleteButton.innerText ='Delete';
                deleteButton.onclick = onDelete.bind(item);
                actions.append(showButton);
                actions.append(editButton);
                actions.append(deleteButton);
                row.append(actions)
                parent.appendChild(row);
            })
        });

    fetch(`${host}/api/courses`)
        .then(response => response.json())
        .then(response => {
            const parent = getElement("courses");
            response.forEach(item => {
                let row = createRow();
                row.append(createCol(item.id));
                row.append(createCol(item.name));
                row.append(createCol(item.code));
                const actions = document.createElement('td');
                const editButton = document.createElement('button');
                editButton.innerText = 'Edit';
                editButton.onclick = onEditCourse.bind(item);
                const deleteButton = document.createElement('button');
                deleteButton.innerText ='Delete';
                deleteButton.onclick = onDeleteCourse.bind(item);
                actions.append(editButton);
                actions.append(deleteButton);
                row.append(actions)
                parent.appendChild(row);
            })
        });
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
function onShow() {
    location.assign(`${host}/courses.html?id=${this.id}`)
}

function onAdd() {
    location.assign(`${host}/edit.html`)
}
function onAddCourse() {
    location.assign(`${host}/editCourse.html`)
}

function onEdit() {
    location.assign(`${host}/edit.html?id=${this.id}`)
}

function onEditCourse() {
    location.assign(`${host}/editCourse.html?id=${this.id}`)
}

function onDelete() {
   const yes = confirm("Are you sure?");
   if (yes) {
       fetch(`${host}/api/students/${this.id}`, {method: 'DELETE'})
           .then(response => {
               alert('Successfully deleted');
           });
   }
}

function onDeleteCourse() {
    const yes = confirm("Are you sure?");
    if (yes) {
        fetch(`${host}/api/courses/${this.id}`, {method: 'DELETE'})
            .then(response => {
                alert('Successfully deleted');
            });
    }
}