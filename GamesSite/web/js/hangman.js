let zichtbaar = 0;
let pics = [];

function setup() {
    let canvas = createCanvas(700, 700);
    canvas.parent('canvas');

    for (let i = 0; i < 14; i++) {
        let path = "images/"+ i + ".png";
        let img = loadImage(path);
        pics.push(img);
    }
}

function draw() {
    background(200, 40, 40);

    image(pics[zichtbaar], 0, 0, 700, 700);
}

function sendMove() {
    let key = document.getElementById("key").value.replace(/(\r\n|\n|\r)/gm, "");
    let letter = document.getElementById("letter").value.replace(/(\r\n|\n|\r)/gm, "");
    let username = document.getElementById("username").value.replace(/(\r\n|\n|\r)/gm, "");
    let woord = document.getElementById("woord").value.replace(/(\r\n|\n|\r)/gm, "");
    $.ajax({
        type: 'POST',
        data: {"command": "move", "key": key, "letter": letter, "woord": woord, "username": username},
        url: 'game',
        success: function (result) {
            console.log(result);
            result = JSON.parse(result);
            zichtbaar = result["zichtbaar"];
            document.getElementById("hint").innerHTML = result["hint"];
            if (result["done"]) {
                let element = document.getElementById("link");
                element.style.display = "block";
            }
        }
    });
}