import mongoose from 'mongoose';
import TweetSchema from '../schemas/TweetSchema';

const TweetsModel = mongoose.model("tweet", TweetSchema);

export default TweetsModel;
