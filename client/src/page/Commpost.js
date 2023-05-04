import styled from "styled-components";
import { useState, useEffect } from "react";
import React from "react";
import axios from "axios";
import ReactPaginate from "react-paginate";

const CommpostDesign = styled.div`
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font-family: "Noto Sans KR", sans-serif;
  vertical-align: baseline;

  ul {
    display: flex;
    background-color: #ffa1a1;
    overflow: hidden;
    white-space: nowrap;
    align-items: center;
    height: 20px;
    line-height: 20px;
    cursor: pointer;
    .postid {
      flex: 0.2;
    }
    .postname {
      flex: 0.4;
    }
    .posttitle {
      flex: 1;
    }
    .postview {
      flex: 0.4;
    }
    .postcreat {
      flex: 0.3;
    }
  }
`;

const Commpost = (props) => {
  const { data } = props;
  const [currentItems, setCurrentItems] = useState(null);
  const [pageCount, setpageCount] = useState(0);
  const [itemOffset, setItemOffset] = useState(0);
  const itemsPerPage = 6;

  useEffect(() => {
    const endOffset = itemOffset + itemsPerPage;
    setCurrentItems(data && data.slice(itemOffset, endOffset));
    setpageCount(Math.ceil(data && data.length / itemsPerPage));
  }, [itemOffset, itemsPerPage, data]);

  const handlePageClick = (event) => {
    const newOffset = (event.selected * itemsPerPage) % items.length;
    setItemOffset(newOffset);
  };

  return (
    <CommpostDesign>
      {currentItems &&
        currentItems.map((el) => (
          <ul className="list">
            <li className="postid">{el.commuId}</li>
            <li className="postname">{el.diplayName}</li>
            <li className="posttitle">{el.title}</li>
            <li className="postview">{el.view}</li>
            <li className="postcreat">{el.createdAt}</li>
          </ul>
        ))}

      <ReactPaginate
        breakLabel="..."
        nextLabel="next >"
        onPageChange={handlePageClick}
        pageRangeDisplayed={3}
        pageCount={pageCount}
        previousLabel="< previous"
        renderOnZeroPageCount={null}
      />
    </CommpostDesign>
  );
};

export default Commpost;
