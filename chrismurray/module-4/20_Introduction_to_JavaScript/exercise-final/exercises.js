function sumDouble(x, y) {
  if (x === y) {
    return 2 * (x + y);
  } else {
    return x + y;
  }
}

function hasTeen(x, y, z) {
  let xInRange = x >= 13 && x <= 19;
  let yInRange = y >= 13 && y <= 19;
  let zInRange = z >= 13 && z <= 19;

  return xInRange || yInRange || zInRange;
}

function lastDigit(num1, num2) {
  return num1 % 10 == num2 % 10;
}

function seeColor(input) {
  let result = "";

  if (input.startsWith("red")) {
    result = "red";
  } else if (input.startsWith("blue")) {
    result = "blue";
  }

  return result;
}

function frontAgain(word) {
  return word.substring(0, 2) == word.substring(word.length - 2);
}

function oddOnly(array) {
  let result = array.filter((num) => {
    return num % 2 == 1;
  });
  return result;
}

function cigarParty(cigarCount, isWeekend) {
  const hasMinCigar = cigarCount >= 40;

  return (
    (isWeekend && hasMinCigar) ||
    (!isWeekend && hasMinCigar && cigarCount <= 60)
  );
}

function fizzBuzz(value) {
  let result = value;

  if (value % 3 == 0 && value % 5 == 0) {
    result = "FizzBuzz";
  } else if (value % 5 == 0) {
    result = "Buzz";
  } else if (value % 3 == 0) {
    result = "Fizz";
  }

  return result;
}

function filterEvens(values) {
  const newValues = [];
  for (let i = 0; i < values.length; i++) {
    if (values[i] % 2 == 0) {
      newValues.push(values[i]);
    }
  }
  return newValues;
}

function filterBigNumbers(values) {
  const newValues = [];
  for (let i = 0; i < values.length; i++) {
    if (values[i] >= 100) {
      newValues.push(values[i]);
    }
  }
  return newValues;
}

function filterMultiplesOfX(values, multipleOf) {
  const newValues = [];
  for (let i = 0; i < values.length; i++) {
    if (values[i] % multipleOf == 0) {
      newValues.push(values[i]);
    }
  }
  return newValues;
}

function createObject() {
  const obj = {
    firstName: "John",
    lastName: "Smith",
    age: 40
  };

  return obj;
}
