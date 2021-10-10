import React, {Component} from "react";

import CardDeck from "react-bootstrap/CardDeck";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";

//data for post
// import data from "./jobs.json";

export default class Jobslist extends Component {
    jobStatus;
    url;
    intervalID;
    constructor(props) {
      super(props);
      this.jobStatus = props.status;
      this.url="http://localhost:8080/jobs/v1/status/"+this.jobStatus;
      this.state = {
        error: null,
        isLoaded: true,
        items: [],
        
      };
    }

    componentDidMount() {
      this.getData();
    
}

componentWillUnmount() {
  /*
    stop getData() from continuing to run even
    after unmounting this component. Notice we are calling
    'clearTimeout()` here rather than `clearInterval()` as
    in the previous example.
  */
  clearTimeout(this.intervalID);
}

getData = () =>{
  fetch(this.url)
    
    .then(res => res.json())
    .then(
       (result) => {
          // console.log(">>>> "+ result);
         this.setState({
          
           isLoaded: true,
           items:result
          
         });
         this.intervalID = setTimeout(this.getData.bind(this), 500);
         // console.log("<<<<<<< "+ this.state.items);
       },
       // Note: it's important to handle errors here
       // instead of a catch() block so that we don't swallow
       // exceptions from actual bugs in components.
       (error) => {
         this.setState({
           isLoaded: true,
           error
         });
       }
     )
}
    
      render() {
        const { error, isLoaded, items } = this.state;
        if (error != null) {
          return <div>Error: <a href={this.url} target="_blank">Link</a> {error.message}</div>;
        } else if (!isLoaded) {
          return <div>Loading...</div>;
        } else {
          return (
            <>
            
              <Container fluid={true}>
                <Row><div className="title">Jobs with status {this.jobStatus}: {items.length}</div></Row>
                <Row>
                  <CardDeck className=' no-gutters '>
                    {/* <ul> */}
                    {items.map((postData) => {
                      // console.log(postData);
                      return (
                         <li>
                          {postData.id + ". " + postData.jobName}
                          </li>
                        // <Card  key={postData.id}>
                        //   {/* <Card.Img variant="top" src={postData.image} /> */}
                        //   <Card.Body>
                        //     <Card.Title >
                        //       {postData.id + ". " + postData.jobName}
                        //     </Card.Title>
                        //     <Card.Subtitle >
                        //       {/* {postData.add_dt + " " + postData.addCd} */}
                        //     </Card.Subtitle>
      
                        //     <Card.Text >
                        //       {/* {postData.jobDesc} */}
                              
                        //     </Card.Text>
                        //   </Card.Body>
                        // </Card>
                      );
                    })}
                    {/* </ul> */}
                  </CardDeck>
                </Row>
              </Container>
            </>
          );
        }
      }
    }