import mongoose from 'mongoose';
import TrendsSchema from '../schemas/TrendsSchema';

const TrendsModel = mongoose.model("trend", TrendsSchema);

export default TrendsModel;
