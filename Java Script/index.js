console.log("Welcome to the Community Portal");

window.onload = () => {
  alert("Page is fully loaded");
};

const eventName = "Community Cleanup";
const eventDate = "2025-06-30";
let availableSeats = 25;
console.log(`Event: ${eventName} on ${eventDate} with ${availableSeats} seats available.`);
function registerSeat() {
  if (availableSeats > 0) {
    availableSeats--;
    console.log(`Seat registered. ${availableSeats} seats left.`);
  } else {
    console.log("No seats available.");
  }
}

const events = [
  { name: "Music Fest", date: "2025-07-10", seats: 50, category: "music" },
  { name: "Art Workshop", date: "2024-12-01", seats: 0, category: "art" }
];
function showValidEvents(eventList) {
  const today = new Date();
  eventList.forEach(event => {
    const eventDate = new Date(event.date);
    if (eventDate >= today && event.seats > 0) {
      console.log(`Upcoming: ${event.name}`);
    } else {
      console.log(`Skipping: ${event.name}`);
    }
  });
}
try {
  showValidEvents(events);
} catch (error) {
  console.error("Error processing events:", error);
}

function addEvent(eventList, event) {
  eventList.push(event);
}
function registerUser(event) {
  if (event.seats > 0) {
    event.seats--;
    return "Registration successful";
  }
  return "No seats left";
}
function filterEventsByCategory(eventList, category, callback) {
  const filtered = eventList.filter(event => event.category === category);
  return callback(filtered);
}
function registrationCounter() {
  let count = 0;
  return function() {
    count++;
    return count;
  };
}
const totalRegistrations = registrationCounter();

function Event(name, date, seats, category) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
}
Event.prototype.checkAvailability = function() {
  return this.seats > 0;
};
const myEvent = new Event("Book Fair", "2025-08-20", 30, "books");
console.log(Object.entries(myEvent));

const communityEvents = [];
communityEvents.push(new Event("Music Fest", "2025-07-10", 50, "music"));
communityEvents.push(new Event("Cooking Class", "2025-09-15", 20, "workshop"));
const musicEvents = communityEvents.filter(e => e.category === "music");
const displayCards = communityEvents.map(e => `Event: ${e.name} on ${e.date}`);
console.log(displayCards);

const eventsContainer = document.querySelector("#eventsContainer");
function renderEventCard(event) {
  const card = document.createElement("div");
  card.className = "eventCard";
  card.textContent = `${event.name} - ${event.date} - Seats: ${event.seats}`;
  eventsContainer.appendChild(card);
}
communityEvents.forEach(renderEventCard);

document.querySelectorAll(".registerBtn").forEach(btn => {
  btn.onclick = () => alert("Registered!");
});
document.querySelector("#categoryFilter").onchange = function() {
  console.log(`Filtering category: ${this.value}`);
};
document.querySelector("#searchBox").onkeydown = function(event) {
  console.log(`Key pressed: ${event.key}`);
};

function fetchEvents() {
  return fetch("https://mockapi.io/events")
    .then(response => response.json())
    .then(data => {
      console.log("Events fetched", data);
    })
    .catch(error => console.error("Error fetching events", error));
}
async function loadEvents() {
  try {
    console.log("Loading events...");
    const response = await fetch("https://mockapi.io/events");
    const data = await response.json();
    console.log("Events:", data);
  } catch (err) {
    console.error("Fetch error:", err);
  }
}

const displayEvent = ({ name, date }) => `${name} on ${date}`;
const cloneEvents = [...communityEvents];
function greetUser(name = "Guest") {
  console.log(`Hello, ${name}!`);
}
const [firstEvent, ...otherEvents] = communityEvents;
console.log(displayEvent(firstEvent));

const form = document.querySelector("#registrationForm");
form.addEventListener("submit", e => {
  e.preventDefault();
  const name = form.elements["name"].value.trim();
  const email = form.elements["email"].value.trim();
  const selectedEvent = form.elements["eventSelect"].value;
  if (!name || !email) {
    alert("Please fill in all required fields.");
    return;
  }
  console.log(`Registering ${name} for ${selectedEvent}`);
});

function sendRegistration(data) {
  fetch("https://mockapi.io/register", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data),
  })
  .then(res => res.json())
  .then(response => {
    alert("Registration successful!");
  })
  .catch(err => alert("Registration failed"));
}

$('#registerBtn').click(() => {
  alert("Registered with jQuery!");
});
$('.eventCard').fadeIn(500).fadeOut(500);
