<h2>Iniciar sesi�n</h2>

<form action="/login" method="POST">
  <div class="mb-3">
    <label for="usuario" class="form-label">Email</label>
    <input type="text" class="form-control" id="usuario" name="username">
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>