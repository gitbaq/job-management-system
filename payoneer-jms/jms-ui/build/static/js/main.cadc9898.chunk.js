(this["webpackJsonpjms-ui"]=this["webpackJsonpjms-ui"]||[]).push([[0],{20:function(e,t,n){},21:function(e,t,n){},23:function(e,t,n){"use strict";n.r(t);var s=n(1),c=n.n(s),i=n(9),a=n.n(i),r=(n(20),n(21),n(0));var u=function(){return Object(r.jsxs)("header",{children:[Object(r.jsx)("h1",{children:" Job Management System "})," "]})};var j=function(){var e=(new Date).getFullYear();return Object(r.jsx)("footer",{children:Object(r.jsxs)("p",{children:["Copyright \xa9 ",e]})})},o=n(10),l=n(11),d=n(6),h=n(15),b=n(13),O=n(14),g=n(12),m=n(8),x=function(e){Object(h.a)(n,e);var t=Object(b.a)(n);function n(e){var s;return Object(o.a)(this,n),(s=t.call(this,e)).getData=function(){fetch(s.url).then((function(e){return e.json()})).then((function(e){s.setState({isLoaded:!0,items:e}),s.intervalID=setTimeout(s.getData.bind(Object(d.a)(s)),500)}),(function(e){s.setState({isLoaded:!0,error:e})}))},s.jobStatus=e.status,s.url="http://localhost:8080/jobs/status/"+s.jobStatus,s.state={error:null,isLoaded:!0,items:[]},s}return Object(l.a)(n,[{key:"componentDidMount",value:function(){this.getData()}},{key:"componentWillUnmount",value:function(){clearTimeout(this.intervalID)}},{key:"render",value:function(){var e=this.state,t=e.error,n=e.isLoaded,s=e.items;return null!=t?Object(r.jsxs)("div",{children:["Error: ",Object(r.jsx)("a",{href:this.url,target:"_blank",children:"Link"})," ",t.message]}):n?Object(r.jsx)(r.Fragment,{children:Object(r.jsxs)(g.a,{fluid:!0,children:[Object(r.jsx)(m.a,{children:Object(r.jsxs)("div",{className:"title",children:["Jobs with status ",this.jobStatus,": ",s.length]})}),Object(r.jsx)(m.a,{children:Object(r.jsx)(O.a,{className:" no-gutters ",children:s.map((function(e){return Object(r.jsx)("li",{children:e.id+". "+e.jobName})}))})})]})}):Object(r.jsx)("div",{children:"Loading..."})}}]),n}(s.Component);var f=function(e){return Object(r.jsxs)("div",{className:"note",children:[" ",Object(r.jsxs)("h1",{className:"name",children:[" ",e.status," "]}),Object(r.jsx)("p",{children:e.content})," ",Object(r.jsx)("img",{src:"images/"+e.img,alt:e.header}),Object(r.jsx)(x,{status:e.status,children:"||"})]})};var v=function(){return Object(r.jsx)("div",{className:"App",children:Object(r.jsxs)("header",{children:[Object(r.jsx)(u,{}),Object(r.jsx)(f,{header:"Jobs Queue",content:"Queued",img:"queue.png",status:"Q"}),Object(r.jsx)(f,{header:"Jobs Running",content:"Running",img:"running.png",status:"R"}),Object(r.jsx)(f,{header:"Jobs Finished",content:"Successful",img:"success.png",status:"S"}),Object(r.jsx)(f,{header:"Jobs Finished",content:"Failed",img:"failure.png",status:"F"}),Object(r.jsx)(j,{})]})})},p=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,25)).then((function(t){var n=t.getCLS,s=t.getFID,c=t.getFCP,i=t.getLCP,a=t.getTTFB;n(e),s(e),c(e),i(e),a(e)}))};a.a.render(Object(r.jsx)(c.a.StrictMode,{children:Object(r.jsx)(v,{})}),document.getElementById("root")),p()}},[[23,1,2]]]);
//# sourceMappingURL=main.cadc9898.chunk.js.map