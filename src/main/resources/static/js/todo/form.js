$(document).ready(function() {
  $('#submitTodo').click(function(e) {
    e.preventDefault();

    const todoData = {
      title: $('#title').val(),
      content: $('#content').val()
    };

    $.ajax({
      url: '/api/todo',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(todoData),
      success: function(response) {
        console.log('Todo 생성 성공', response);
        window.location.href = '/todo';
      },
      error: function(error) {
        console.log('Todo 생성 오류', error);
        alert("오류!")
      }
    });
  });
});
