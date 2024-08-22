import { createTask } from "./createTask.js"

const button = document.getElementById("open-modal")

export const modal = document.getElementById("task-modal")
export const form = document.getElementById("task-form")

const span = document.getElementsByClassName("close-button")[0]

button.addEventListener('click', () => {
    modal.style.display = "block"
})


window.addEventListener('click', (event) => {
    if (event.target === modal) {
        modal.style.display = "none";
    }
})

span.onclick = function () {
    modal.style.display = "none"
}

form.onsubmit = createTask
