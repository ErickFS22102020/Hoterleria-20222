gsap.registerPlugin(ScrollTrigger);

gsap.to(".square",{
  x: 700,
  duration: 3,
  ScrollTrigger: ".square"
})




gsap.timeline({delay:1, repeatDelay:1.5, repeat:-1, yoyo:true})
    .to('.m', {duration:(i)=>[0.7,1][i], y:-16560, ease:'steps(23)', stagger:0.1}, 0.5)
    .from('.img', {duration:1.5, scale:1.1, transformOrigin:'50% 50%', ease:'power2'}, 0.5);