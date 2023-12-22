$(document).ready(function() {
  $.ajax({
    url: '/api/todo',
    method: 'GET',
    success: function(todos) {
      const todoContainer = $('#todo-container');
      todos.forEach(function(todo) {
        const todoHtml = generateTodoHtml(todo);
        todoContainer.append(todoHtml);
      });
      bindStatusButtonEvents();
    }
  });
});

function generateTodoHtml(todo) {
  let buttonClass = 'btn-secondary';
  let buttonText = '하는중';

  switch (todo.todoStatus) {
    case 'SUCCESS':
      buttonClass = 'btn-success';
      buttonText = '달성';
      break;
    case 'FAIL':
      buttonClass = 'btn-danger';
      buttonText = '실패';
      break;
  }

  return `
    <div class="col-3 mb-4">
      <div class="card" data-todo-id="${todo.id}">
        <div class="card-header">
          ${todo.createdAt}
        </div>
        <div class="card-body">
          <h5 class="card-title">${todo.title}</h5>
          <hr/>
          <div class="text-center">
            ${todo.content}
          </div>
          <hr/>
          <button class="btn ${buttonClass} text-white mt-2 todo-status-btn">${buttonText}</button>
        </div>
      </div>
    </div>`;
}

function bindStatusButtonEvents() {
  $('.todo-status-btn').click(function() {
    const button = $(this);
    const todoId = button.closest('.card').data('todo-id');
    const currentStatus = button.text().trim();

    switch (currentStatus) {
      case '하는중':
        updateTodoStatus(todoId, 'SUCCESS');
        button.removeClass('btn-secondary').addClass('btn-success').text('달성');
        break;
      case '달성':
        updateTodoStatus(todoId, 'FAIL');
        button.removeClass('btn-success').addClass('btn-danger').text('실패');
        break;
      case '실패':
        updateTodoStatus(todoId, 'TRYING');
        button.removeClass('btn-danger').addClass('btn-secondary').text('하는중');
        break;
    }
  });
}

function updateTodoStatus(todoId, newStatus) {
  $.ajax({
    url: '/api/todo/' + todoId + '/status',
    method: 'PUT',
    contentType: 'application/json',
    data: JSON.stringify({ todoStatus: newStatus }),
    success: function(response) {
      console.log("Todo 상태 변경 성공", response);
    },
    error: function(error) {
      console.log("Todo 상태 변경 실패", error);
    }
  });
}
