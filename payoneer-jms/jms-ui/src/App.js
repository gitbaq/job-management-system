//import logo from './logo.svg';
import './App.css';
import Header from "./components/Header";
  import Footer from "./components/Footer";
  import Note from "./components/Note";

  


function App() {
  return (
    <div className="App">
      {/* <header className="App-header"> */}
      <header>
      <Header/>
      <Note header="Jobs Queue" content="Queued" img="queue.png" status="Q"/>
      <Note header="Jobs Running" content="Running" img="running.png" status="R"/>
      <Note header="Jobs Finished" content="Successful" img="success.png" status="S"/>
      <Note header="Jobs Finished" content="Failed" img="failure.png" status="F"/>
      <Footer/>
        
      </header>
    </div>
  );
}

export default App;
