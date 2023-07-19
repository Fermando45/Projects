<?php require (__DIR__ . '/../partials/head.php') ?>

 
<?php require (__DIR__ . '/../partials/navs.php') ?>


<?php require (__DIR__ . '/../partials/banner.php') ?>

  <main>
    <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
  <ul>
      <?php foreach($notes as $note) :?>
        <li>
            <a href='/Laracast/index.php/note?id=<?= $note['id']?>' class = 'text-blue-500 hover:underline'>
            <?= htmlspecialchars($note['body']) ?>
        </a>
    </li>
     <?php endforeach; ?>
  </ul>

  <p class="mt-6">

  <a href="/Laracast/index.php/notes/create" class="text-blue-500 hover:underline">
    Create note
  </a>


  </p>

    </div>
  </main>
  
<?php require (__DIR__ . '/../partials/footer.php') ?>
