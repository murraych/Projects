let problemsPerSession = 10;
let currentProblem = 1;
let score = 0;
let problemSet = [];

/* Events Listeners */
document.addEventListener("DOMContentLoaded", () => {
    let answerListItems = document.querySelectorAll("#answers ul li");
    answerListItems.forEach( (element) => {
        element.addEventListener("click", (e) => {
            const answer = parseInt(e.currentTarget.innerText);
            const correctAnswer = parseInt(problemSet[currentProblem -1].problem.answer);
            if(answer == correctAnswer) {
                score++;
                document.querySelector(".currentScore").innerText = score;
            }
            nextProblem();
       })
    });

    generateProblemSet();
    displayProblem();
    displayAnswers();

});

function nextProblem() {
    if(currentProblem < problemsPerSession) {
        currentProblem++;
        document.querySelector(".currentProblem").innerText = currentProblem;
        displayProblem();
        displayAnswers();
    }
    else {
        const elements = document.querySelectorAll(".show-hide");
        elements.forEach((element) => {
            element.classList.toggle("hidden", currentProblem == problemsPerSession);
        });

    }
}

/* Problem Generation */

/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

/**
 * Utility function to shuffle the items in an array
 * @param {object} arr
 */
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
}

function generateProblemSet() {
    for(p = 0; p < problemsPerSession; ++p) {
        const problem = {
            left: getRandomNumber(10),
            right: getRandomNumber(10),
            answer: null
        }

        problem.answer = problem.left * problem.right;

        const answers = shuffleArray([getRandomNumber(82), getRandomNumber(82), getRandomNumber(82), problem.answer]);

        problemSet.push({problem, answers});
    }
}

function displayProblem(){
    const pContainer = document.getElementById("problem");
    const expression = `${problemSet[currentProblem - 1].problem.left} * ${problemSet[currentProblem - 1].problem.right}`;
    pContainer.querySelector("div.expression").innerText = expression;
}

function displayAnswers(){
    const aContainer = document.getElementById("answers");
    const list = aContainer.querySelector("ul");
    const listItems = list.querySelectorAll("li");
    const answers = problemSet[currentProblem - 1].answers;

    for (let i = 0; i < answers.length; ++i) {
        listItems[i].innerText = answers[i];
    }
}

    /*Alex's Awesome Duplicate Issue*/
    function cleanAnswers(){}

