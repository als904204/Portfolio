$(document).ready(function() {
  $.ajax({
    url: '/api/todo',
    method: 'GET',
    success: function(todos) {
      const todoContainer = $('#todo-container');
      todos.forEach(function(todo) {
        const buttonsHtml = createStatusButtons(todo.todoStatus);
        const todoHtml = `
                    <div class="col-3 mb-4">
                        <div class="card">
                            <div class="card-header ">
                                ${todo.createdAt}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${todo.title}</h5>
                                <hr/>
                                  <div class="text-center">
                                           ${todo.content}
                                   </div>
                                  <hr/>
                                   ${buttonsHtml}
                            </div>
                        </div>
                    </div>`;
        todoContainer.append(todoHtml);
      });
    }
  });
});


function createStatusButtons(todoStatus) {
  switch (todoStatus) {
    case 'SUCCESS':
      return '<button class="btn btn-success mt-2">달성</button>';
    case 'FAIL':
      return '<button class="btn btn-danger mt-2">실패</button>';
    case 'TRYING':
      return '<button class="btn btn-secondary text-white mt-2">하는중</button>';
    default:
      return '<button class="btn btn-secondary mt-2">상태 불명</button>';
  }
}

