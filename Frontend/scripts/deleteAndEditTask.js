import { modal, form} from "./modal.js";

function excludeTask(event){
    const taskItem = event.target.closest('li');
    if (taskItem) {
        taskItem.remove();
    }
}

document.addEventListener('click', function(event) {
    if (event.target.classList.contains('delete-task')) {
        excludeTask(event);
    }

    if (event.target.classList.contains('edit-task')){

        const taskElement = event.target.closest('li');

        let taskToEdit = {
            name: taskElement.querySelector('.task h2 span').textContent,
            description: taskElement.querySelector('.task p:nth-of-type(1) span').textContent,
            priority: taskElement.querySelector('.task p:nth-of-type(2) span').textContent,
            category: taskElement.querySelector('.task p:nth-of-type(4) span').textContent,
            finalDate: taskElement.querySelector('.task p:nth-of-type(5) span').textContent,
        }

        form.reset()

        document.getElementById('task-name').value = taskToEdit.name;
        document.getElementById('task-description').value = taskToEdit.description;
        document.getElementById('task-priority').value = taskToEdit.priority;
        document.getElementById('task-category').value = taskToEdit.category;
        document.getElementById('task-date').value = taskToEdit.finalDate;

        modal.style.display='block'
 }

});