<!DOCTYPE html>
<html lang="en">
<head>
    <script src="javascript/themeChanger.js">
    </script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Text</title>
</head>

<body>

<h2>Add new Text</h2>

<form action="add-text" method="post">

                <p>Title:</p>
                <p><input class="box" type="text" name="title" autofocus></p>

                <p>Question: </p>
                <p><textarea rows="20" cols="20" name="text"></textarea></p>

                <br>
                <select name="is_published" size="1">
                        <option value="false">unpublished</option>
                        <option value="true">published</option>
                </select>
                <br>
                <br>
                <br>
                <p><input class="button" type="submit"></p>
</form>
</body>
