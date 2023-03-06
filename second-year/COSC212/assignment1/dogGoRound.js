let DogGoRound = (function () {
    let pub = {};
    let dogList, dogIndex, dog1, dog2, dog3;

    function Dog(title, image, page) {
        this.title = title;
        this.image = image;
        this.page = page;
        this.makeHTML = function () {
            return ("<a href=\"" + page + "\"><figure><img alt=\"\" src=\"" + image + "\">" +
                "<figcaption>" + title + "</figcaption></figure></a>");
        }
    }

    function nextDog() {
        let target;
        if (dogIndex === 3) {
            dogIndex = 0;
        }
        target = document.getElementById("spin");
        target.innerHTML = dogList[dogIndex].makeHTML();
        dogIndex += 1;
    }

    pub.setup = function () {
        dogList = [];
        dogList.push(dog1 = new Dog("Click image for full list of dogs", "images/medium.jpg", "dogs.html"));
        dogList.push(dog2 = new Dog("Click image for full list of dogs", "images/large.jpg", "dogs.html"));
        dogList.push(dog3 = new Dog("Click image for full list of dogs", "images/huge.jpg", "dogs.html"));
        dogIndex = 0;
        nextDog();
        setInterval(nextDog, 2000);
    };
    return pub;
}());

$(document).ready(DogGoRound.setup);