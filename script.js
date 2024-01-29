let users = [];
let editIndex = null;

function addUser() {
  let name = document.getElementById('username').value;
  let permission = document.getElementById('userpermission').value;

  if (editIndex !== null) {
    users[editIndex] = {name, permission};
    editIndex = null;
  } else {
    users.push({name, permission});
  }

  document.getElementById('username').value = '';
  document.getElementById('userpermission').value = 'level1';

  displayUsers();
}

function displayUsers() {
  let table = document.getElementById('userTable');
  table.innerHTML = '<tr><th>사용자명</th><th>권한</th><th>수정</th><th>삭제</th></tr>';
  
  for(let i = 0; i < users.length; i++) {
    let row = `<tr>
                 <td>${users[i].name}</td>
                 <td>${users[i].permission}</td>
                 <td><button onclick="editUser(${i})">수정</button></td>
                 <td><button onclick="deleteUser(${i})">삭제</button></td>
               </tr>`;
    
    table.innerHTML += row;
  }
}

function editUser(index) {
  let user = users[index];
  document.getElementById('username').value = user.name;
  document.getElementById('userpermission').value = user.permission;
  editIndex = index;
}

function deleteUser(index) {
  users.splice(index, 1);
  displayUsers();
}
