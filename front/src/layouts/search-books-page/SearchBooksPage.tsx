import type { BookModel } from '../../model/BookModel';
import { SearchBook } from './components/SearchBook.tsx';
import { useEffect, useState } from 'react';
import { bookService } from '../../services/bookService.ts';
import { SpinnerLoading } from '../../components/SpinnerLoading.tsx';
import {Pagination} from "./components/Pagination.tsx";

export const SearchBooksPage = () => {

  const BOOK_PER_PAGE = 5;

  const [books, setBooks] = useState<BookModel[]>([]);
  const [isLoading, setIsLoading] = useState<boolean>(true);
  const [httpError, setHttpError] = useState<string | null>();
  const [currentPage, setCurrentPage] = useState<number>(1);
  const [totalBooks, setTotalBooks] = useState<number>(0);
  const [totalPages, setTotalPages] = useState<number>(0);

  useEffect( ()=> {
        const fetchBooks = async () => {
          try {
            const pageNo = currentPage - 1;
            const data = await bookService.getBooks(pageNo, BOOK_PER_PAGE);
            console.log(data);
            setBooks(data.content);
            setTotalBooks(data.totalElements);
            setTotalPages(data.totalPages);
            setIsLoading(false);
            window.scrollTo(0,0); // each time we change the page on the bottom, automatically go to the top of the page
          } catch(error) {
            setIsLoading(false);
            setHttpError(error instanceof Error ? error.message : "An error has occured");
          }
        };
        fetchBooks();
  }, [currentPage]); // re-render based on currentPage

  if(isLoading){
    return <SpinnerLoading/>
  }

  if(httpError){
    return <div className="container m-5">{httpError}</div>;
  }

  const indexOfFirstPage = (currentPage - 1) * BOOK_PER_PAGE + 1;
  const lastItem = Math.min(currentPage * BOOK_PER_PAGE, totalBooks);

  return (
    <>
      <div className="container">
        <div>
          <div className="row mt-5">
            <div className="col-6">
              <div className="d-flex">
                <input
                  className="form-control me-2"
                  type="search"
                  placeholder="Search"
                  aria-labelledby="Search"
                />
                <button className="btn btn-outline-success">Search</button>
              </div>
            </div>

            <div className="col-4">
              <div className="dropdown">
                <button
                  className="btn btn-secondary dropdown-toggle"
                  type="button"
                  id="dropdownMenuButton1"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Category
                </button>

                <ul
                  className="dropdown-menu"
                  aria-labelledby="dropdownMenuButton1"
                >
                  <li>
                    <a className="dropdown-item" href="#">
                      All
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      Front End
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      Back End
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      Data
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      DevOps
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>

          <div className="mt-3">
            <h5>Number of results: (3)</h5>
          </div>

          <p>{indexOfFirstPage} to {lastItem} of {totalBooks} items:</p>

          {books.map((book) => (
              <SearchBook book={book} key={book.id} />
          ))}
          {totalPages > 1 && (
              <Pagination
                  currentPage={currentPage}
                  totalPages={totalPages}
                  paginate={setCurrentPage}
              />
          )}
        </div>
      </div>
    </>
  );
};
