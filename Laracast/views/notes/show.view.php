<?php require (__DIR__ . '/../partials/head.php') ?>

 
<?php require (__DIR__ . '/../partials/navs.php') ?>


<?php require (__DIR__ . '/../partials/banner.php') ?>

  <main>
    <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
        <p>
            <a href="/Laracast/index.php/notes" class = "text-blue-500 underline"> 
             go back ...
            </a>
        </p>
        <p>
            <?= htmlspecialchars($notes['body'])?>
        </p>

    </div>
  </main>
  
  <?php require (__DIR__ . '/../partials/footer.php') ?>
