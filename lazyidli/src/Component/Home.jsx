import React from 'react';
import './Home.css';
import tehoimage from './images/tehoimage.png';
import animationimage2 from './images/animationimage2.png';
import animationimage3 from './images/animationimage3.png';
import { useState, useEffect } from 'react';

export default function Home() {
  const [backgroundImage, setBackgroundImage] = useState(animationimage2);
  const [players, setPlayers] = useState([]);
  const [name, setName] = useState('');
  const [time, setTime] = useState('');
  const [popup, setPopup] = useState(false);
  const [popupContent, setPopupContent] = useState('');

  useEffect(() => {
    setBackgroundImage(animationimage3);
  }, []);

  const addPlayer = (e) => {
    e.preventDefault();

    const [hours, minutes, seconds] = time.split(':').map(Number);

    const totalSeconds = (hours || 0) * 3600 + (minutes || 0) * 60 + (seconds || 0);

    const newPlayer = { name, time: totalSeconds };

    setPlayers([...players, newPlayer]);
    setName('');
    setTime('');
    setPopupContent(`${name} ${time} is added!`);
    setPopup(true);
    setTimeout(()=> setPopup(false), 5000);
  };

  const div_style = {
    backgroundImage: `url(${backgroundImage})`,
  };

  return (
    <div className="outer_div">
      {popup && <div className="popup">{popupContent}</div>}
      <div className="main_div">
        <div className="top_div">
          <img className="left_image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnf-E1rdaYW78mRrQ9-c6lem5mxHCZYSdbaw&s" alt="kosimage" />
          <img className="right_image" src={tehoimage} alt="tehoimage" />
        </div>

        <div className="top_trans">
          <div>
            <hr className="first_hr" />
            <hr className="second_hr" />
            <hr className="third_hr" />
          </div>
          LEADERBOARD
          <div>
            <hr className="first_hr2" />
            <hr className="second_hr2" />
            <hr className="third_hr2" />
          </div>
        </div>

        <div className="middle_div">
          <div className="below_trans">
            <h5>NAME</h5>
            <h5>TIME</h5>
          </div>

          <div className="scroll_div">
            <table className="scroll_table">
              <tbody>
            {players
              .sort((a, b) => a.time - b.time)
              .slice(0, 20)
              .map((player, index) => {
                const hours = Math.floor(player.time / 3600);
                const minutes = Math.floor((player.time % 3600) / 60);
                const seconds = player.time % 60;

                return (
                  <tr className="name_div" key={index}>
                    <td className="num_div">{index + 1}</td>
                    <td className="names">{player.name}</td>
                    <td className="times">
                      {String(hours).padStart(2, '0')}:
                      {String(minutes).padStart(2, '0')}:
                      {String(seconds).padStart(2, '0')}
                    </td>
                  </tr>
                );
              })}
              </tbody>
              </table>
          </div>
        </div>

        <div style={div_style} className="last_div">
          <img className="image2" src={animationimage2} alt="image2" />
          <img className="image3" src={animationimage3} alt="image3" />
        </div>
        <div className="footer_div">
          Get your name on leaderboard win exciting prizes!
        </div>
      </div>
      <form onSubmit={addPlayer} className="form_div">
        <input
          type="text"
          placeholder="Player Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required/>
        <input
          type="text"
          placeholder="HH:MM:SS"
          value={time}
          onChange={(e) => setTime(e.target.value)}
          required
          pattern="^([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])$"
          title="Time format should be HH:MM:SS"/>
        <button type="submit">Add Player</button>
      </form>
    </div>
  );
}