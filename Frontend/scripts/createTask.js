import { modal, form } from "./modal.js";

export function createTask(event) {
   event.preventDefault();
   
   let task = {
      name: document.getElementById("task-name").value,
      description: document.getElementById("task-description").value,
      finalDate: document.getElementById("task-date").value,
      status: document.getElementById("task-status").value,
      category: document.getElementById("task-category").value,
      priority: document.getElementById("task-priority").value
   }


   const ul = document.querySelector(".tasks ul");
   const li = document.createElement("li");

   li.innerHTML = `
         <div class="task">
            <h2>Nome: <span>${task.name}</span></h2>
            <p>Descricao: <span>${task.description}</span></p>
            <p>Prioridade: <span>${task.priority}</span></p>
            <p>Status: <span>${task.status}</span></p>
            <p>Categoria: <span>${task.category}</span></p>
            <p>Data Final: <span>${task.finalDate}</span></p>
         </div>
         <div class="buttons">
            <button class="delete-task"> excluir </button>
            <button class="edit-task"> editar </button>
          </div>
    `;

   ul.appendChild(li);
   form.reset();

   modal.style.display = "none";
}
