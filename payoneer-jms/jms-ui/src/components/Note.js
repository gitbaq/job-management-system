import React from "react";

import JobsList from "./Jobslist";

function Note(props) {
  return ( < div className = "note" > < h1 className="name"> {props.status} < /h1><p>{props.content}</p > <img src={"images/"+props.img} alt={props.header}/>
  <JobsList status={props.status}>||</JobsList>
  {/* <DefaultPost></DefaultPost> */}
  < /div>);
  }

  export default Note;