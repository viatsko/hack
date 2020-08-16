# Implementation:

### Q) What libraries did you add to the frontend? What are they used for?

### Q) What is the command to start the server?

(Default) `APIKEY=<key> npm run server`

---

# General:

### Q) How long, in hours, did you spend on the test?

### Q) If you had more time, what further improvements or new features would you add?

### Q) Which parts are you most proud of? And why?

### Q) Which parts did you spend the most time with? What did you find most difficult?

I've spent the most time with Backpack documentation.

### Q) How did you find the test overall? If you have any suggestions on how we can improve the test or our API, we'd love to hear them.

1) The "requirement" of using Backpack didn't make me happy (and I call it requirement because otherwise it wouldn't be provided as a part of template application).

Documentation on Backpack is not super clear and I've had to invest some time figuring out how to do things using that framework.

E. g. https://backpack.github.io/tokens/colors#primary It's not possible to figure out how to use it without looking at the source code of the library itself (that is `color-white` should in fact be used as `$bpk-color-white`). It wasn't clear on how to pass a custom class name to a react component since examples I've looked at in the documentation were lacking it.

I understand you're looking for dedicated people, but if we both know that learning style guide to work at max speed won't take more than a week, what's the point? It "eats" the time that would've spent doing the exercise otherwise.

Other issues connected to Backpack:

I've used BpkLinkButton, but got index.js:2178 Warning: Failed prop type: The prop `href` is marked as required in `BpkLink`, but its value is `undefined`. I'd assume that the right behaviour is to check for either onClick or href, not requiring both?

2) Would be nice to have designs in Figma/Zeplin format as well. Sketch doesn't work on Windows/Linux machines which are popular choices nowadays.

3) Why? 😭 `const c = className => STYLES[className] || 'UNKNOWN';`

4) Price alerts icon doesn't match guidelines (design vs https://backpack.github.io/components/icon?platform=web). I've used SVGs from Sketch instead.

