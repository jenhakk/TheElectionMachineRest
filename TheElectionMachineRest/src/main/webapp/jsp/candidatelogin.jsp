<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style2.css">
    <title>Candidate login</title>
</head>

<body id="candnum"
    style="background-image: url('/pics/minioncandidate.png'); background-repeat: no-repeat;background-position: right 200px bottom 100px;background-size: 25vw;">

    <main>
    <div class="col"><a href="/index.html" class="btnhome">HOME</a></div>
        <div class="container">
            <h2 id="enter">Enter your candidate number:</h2>

            <div class="row2">
                <div class="col">
                <form action="/CandidateLogin" method="post">
                <input type="text" id="candi_id" name="candi_id" value="">

                </div>

                <div class="col">
                 <input type="submit" name="ok" class="btn btn-primary" value="SUBMIT">
                </div>
                </form>

            </div>

        </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>