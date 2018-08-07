<!DOCTYPE html>
<html>
<?php $final=7 ?>
<head>
  <meta charset="ISO-8859-1">
  <title>Teste de Produção</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
  console.log(122);
  function validar() {
    let x = []
    for (var i=1;i< <?php echo $final ?>;i++) {
      x.push(document.getElementById("Carro_" + i).value);
    }
    console.log(x);
  }
</script>
<body>
  <div class="container">
    <div class="row">
      <div class="header col-md-12">
        <h1>Teste de Produção</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-md-3">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
          sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
           Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
            ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
      <div class="col-md-9">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
    <form class="form-group" action="#" method="GET">
        <?php  
        $list = [
          "http://www.unidas.com.br/media/16722/unidas-aluguel-de-carro-grupo-e-compacto-hyundai-hb20-final.png",
          "http://www.unidas.com.br/media/16722/unidas-aluguel-de-carro-grupo-e-compacto-hyundai-hb20-final.png",
          "http://www.unidas.com.br/media/16722/unidas-aluguel-de-carro-grupo-e-compacto-hyundai-hb20-final.png",
          "http://www.unidas.com.br/media/16722/unidas-aluguel-de-carro-grupo-e-compacto-hyundai-hb20-final.png",
          "http://www.unidas.com.br/media/16722/unidas-aluguel-de-carro-grupo-e-compacto-hyundai-hb20-final.png",
          "http://www.unidas.com.br/media/16722/unidas-aluguel-de-carro-grupo-e-compacto-hyundai-hb20-final.png"
        ];
          for ($i=1; $i < $final; $i++){
            echo "<div class=\"row\">";
              echo "<h4 class=\"col-md-2\">Carro $i:</h4>";
              echo "<div class=\"form-group\">";
                  $element = $list[$i-1];
                  echo "<img class=\"img-fluid\"src=\"$element\" alt=\"carro$i\">";
                  echo "<div class=\"row\">";
                    echo "<div class=\"col-md-2\">";
                      echo "<p style=\"color: #a86535\">Valor:</p>";
                    echo "</div>";
                    echo "<div class=\"col-md-10\">";
                      echo "<input type=\"text\" class=\"form-control col-md-10\" id=\"Carro_$i\" name=\"$i\">"; //required
                    echo "</div>";
                  echo "</div>";
              echo "</div>";
            echo "</div>";
            echo "<hr>";
          }
        ?>
      <div class="row">
        <button type="submit" onclick="validar()" class="btn btn-primary btn-md col-md-12" name="envio" value="Enviar">Enviar</button>
      </div>
      <hr>
    </form>
  </div>
</body>
</html>
