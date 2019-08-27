<!DOCTYPE html>
<html lang="en">
<head>
    <script src="javascript/themeChanger.js">
    </script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Assignment</title>
</head>

<body>

<h2>Add new Assignment</h2>

<form action="add-assignment" method="post">

                <p>Title:</p>
                <p><input class="box" type="text" name="title" autofocus></p>

                <p>Question: </p>
                <p><textarea rows="20" cols="20" name="question"></textarea></p>

                <p>Possible Max Score: </p>
                <p><input type="number" min="1" max="10" name="max_score"></p>
                <br>
                <select name="is_published" size="1">
                        <option value="true">published</option>
                        <option value="false">unpublished</option>
                </select>
                <br>
                <br>
                <br>
                <p><input class="button" type="submit"></p>
</form>
</body>
